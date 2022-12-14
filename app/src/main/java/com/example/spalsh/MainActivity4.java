package com.example.spalsh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        private ActivityOtpSendBinding binding;
        private FirebaseAuth mAuth;
        private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            binding = ActivityOtpSendBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            mAuth = FirebaseAuth.getInstance();

            binding.btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (binding.etPhone.getText().toString().trim().isEmpty()) {
                        Toast.makeText(OtpSendActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                    } else if (binding.etPhone.getText().toString().trim().length() != 10) {
                        Toast.makeText(OtpSendActivity.this, "Type valid Phone Number", Toast.LENGTH_SHORT).show();
                    } else {
                        otpSend();
                    }
                }
            });
        }

        private void otpSend () {
            binding.progressBar.setVisibility(View.VISIBLE);
            binding.btnSend.setVisibility(View.INVISIBLE);

            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                @Override
                public void onVerificationCompleted(PhoneAuthCredential credential) {

                }

                @Override
                public void onVerificationFailed(FirebaseException e) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.btnSend.setVisibility(View.VISIBLE);
                    Toast.makeText(OtpSendActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCodeSent(@NonNull String verificationId,
                                       @NonNull PhoneAuthProvider.ForceResendingToken token) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.btnSend.setVisibility(View.VISIBLE);
                    Toast.makeText(OtpSendActivity.this, "OTP is successfully send.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(OtpSendActivity.this, OtpVerifyActivity.class);
                    intent.putExtra("phone", binding.etPhone.getText().toString().trim());
                    intent.putExtra("verificationId", verificationId);
                    startActivity(intent);
                }
            };

            PhoneAuthOptions options =
                    PhoneAuthOptions.newBuilder(mAuth)
                            .setPhoneNumber("+91" + binding.etPhone.getText().toString().trim())
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(this)
                            .setCallbacks(mCallbacks)
                            .build();
            PhoneAuthProvider.verifyPhoneNumber(options);
        }
    }
}