//package com.example.evoter;
//
//import at.favre.lib.crypto.bcrypt.BCrypt;
//import org.mindrot.jbcrypt.BCrypt;
//
//
//public class Testing {
//        public static String hashPassword(String password) {
//            String salt = BCrypt.gensalt();
//            return BCrypt.hashpw(password, salt);
//        }
//
//        public static void registerUser(String username, String password) {
//            String hashedPassword = hashPassword(password);
//
//            // Store the username and hashed password in the user database
//        }
//
//        public static boolean authenticateUser(String username, String password) {
//            // Retrieve the hashed password from the user database for the given username
//
//            return BCrypt.checkpw(password, storedHashedPassword);
//        }
//
//        public static void main(String[] args) {
//            String username = "exampleUser";
//            String password = "password123";
//
//            // Register a new user
//            registerUser(username, password);
//
//            // Authenticate the user
//            boolean isAuthenticated = authenticateUser(username, password);
//            System.out.println("User authentication: " + isAuthenticated);
//        }
//    }
//
//}
////        public static String hashPassword(String password) {
////            int complexityFactor = 10; // Set the desired complexity factor
////            BCrypt.Hasher hasher = BCrypt.withDefaults();
////            String hashedPassword = hasher.hashToString(complexityFactor, password.toCharArray());
////            return hashedPassword;
////        }
////
////        public static boolean authenticateUser(String password, String hashedPassword) {
////            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);
////            return result.verified;
////        }
////
////        public static void main(String[] args) {
////            String password = "password123";
////
////            // Hash the password
////            String hashedPassword = hashPassword(password);
////            System.out.println("Hashed password: " + hashedPassword);
////
////            // Authenticate the user
////            boolean isAuthenticated = authenticateUser(password, hashedPassword);
////            System.out.println("User authentication: " + isAuthenticated);
////        }
////    }
//
////    public static String hashPassword(String password, String salt) {
////        String saltedPassword = salt + password;
////        return DigestUtils.sha256Hex(saltedPassword);
////    }
////
////    public static void main(String[] args) {
////        String password = "password123";
////        String salt = "somesalt";
////
////        String saltedHashedPassword = hashPassword(password, salt);
////        System.out.println("Salted and hashed password: " + saltedHashedPassword);
////    }
//
