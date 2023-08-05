package com.example.compario.util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class firebaseutil {
    public static String currentUserId(){

        return FirebaseAuth.getInstance().getUid();
    }
    public static DocumentReference currentUserDetails(){

        return FirebaseFirestore.getInstance().collection("users").document(currentUserId());
    }
}
