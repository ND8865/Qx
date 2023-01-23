package Labelling;

public class DataRepository {
	
	public static String[] getDataRepository(String methodName, String className) {
		String[] result = new String[3];
		
		if(className.equals("SuperAdmin_LoginTests")) {
			result = SuperAdmin_LoginTests(methodName, className);
		}
		else if(className.equals("SuperAdmin_SuperAdminsTests")) {
			result = SuperAdmin_SuperAdminsTests(methodName, className);
		}
		return result;
	}
	
	public static String[] SuperAdmin_SuperAdminsTests(String methodName, String className) {
		try {
			String[] result = new String[3];
			int methodNum = Integer.parseUnsignedInt(methodName.substring(10));
			
			if((methodName.equals("JEEVAINFOR39"))) {
				result[0] = "SUPER_ADMIN";
				result[1] = "Search";
				result[2] = "1";
			}
			else if((methodName.equals("JEEVAINFOR50"))) {
				result[0] = "SUPER_ADMIN";
				result[1] = "AddSuperAdmin";
				result[2] = "1";
			}
			else if((methodName.equals("JEEVAINFOR58"))) {
				result[0] = "SUPER_ADMIN";
				result[1] = "Confirmation&OTP&CreatePassword";
				result[2] = "1";
			}
			else if((methodName.equals("JEEVAINFOR71"))) {
				result[0] = "SUPER_ADMIN";
				result[1] = "deleteUser";
				result[2] = "1";
			}
			else if((methodNum >= 51) && (methodNum <= 61)) {
				result[0] = "SUPER_ADMIN";
				result[1] = "Confirmation&OTP&CreatePassword";
				result[2] = "0";
			}
			else if((methodName.equals("JEEVAINFOR63")) || (methodName.equals("JEEVAINFOR65")) || (methodName.equals("JEEVAINFOR66"))) {
				result[0] = "SUPER_ADMIN";
				result[1] = "EditUser";
				result[2] = "1";
			}
			else if((methodName.equals("JEEVAINFOR64"))) {
				result[0] = "SUPER_ADMIN";
				result[1] = "ConfirmationMailEditUser";
				result[2] = "1";
			}
			else if((methodName.equals("JEEVAINFOR68"))) {
				result[0] = "SUPER_ADMIN";
				result[1] = "addUserWithPreviousDetails";
				result[2] = "1";
			}
			else if((methodNum >= 62)&&(methodNum <= 68)) {
				result[0] = "SUPER_ADMIN";
				result[1] = "EditUser";
				result[2] = "0";
			}
			else if((methodNum >= 69)&&(methodNum <= 72)) {
				result[0] = "SUPER_ADMIN";
				result[1] = "deleteUser";
				result[2] = "0";
			}
			return result;
		}
		catch(Exception e) {
			System.out.println("Exception in DataRepository for SuperAdmin_SuperAdminsTests - "+e);
			return null;
		}
	}
	
	public static String[] SuperAdmin_LoginTests(String methodName, String className) {
		try {
			String[] result = new String[3];
			int methodNum = Integer.parseUnsignedInt(methodName.substring(10));
			
			if((methodName.equals("JEEVAINFOR26")) || (methodName.equals("JEEVAINFOR35"))) {
				result[0] = "LOGIN&LOGOUT";
				result[1] = "LoginCredentials";
				result[2] = "1";
			}
			else if((methodNum >= 21) && (methodNum <= 36)) {
				result[0] = "LOGIN&LOGOUT";
				result[1] = "LoginCredentials";
				result[2] = "0";
			}
			return result;
		}
		catch(Exception e) {
			System.out.println("Exception in DataRepository for SuperAdmin_LoginTests - "+e);
			return null;
		}
	}

}
