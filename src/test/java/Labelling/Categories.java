package Labelling;

public class Categories{
	
	/**
	 * Method to manually create the names of the categories for Report.
	 * @param className - The name of the class for which the test case is executing.
	 * @return - The manually assigned name for the set of test cases belonging to a class.
	 */
	public static String getCategoryName(String className) {
		
		String category = "";
		
		if(className.equals("TestScripts_Sprint01.SignInGamer_Test")) {
			category = "Gamer | Sign In & Sign Out";
		}
		else if(className.equals("TestScripts_Sprint01.SignUp_Gamer_Tests")) {
			category = "Gamer | Sign Up";
		}
		else if(className.equals("TestScripts_Sprint01.ChangePasswordOfAccount_Tests")) {
			category = "Gamer | Reset Password";
		}
		else if(className.equals("TestScripts_Sprint01.ForgotPassword_Gamers_Test")) {
			category = "Gamer | Forgot Password";
		}
		else if(className.equals("TestScripts_Sprint01.Dashboard_Gamer_Tests")) {
			category = "Gamer | Dashboard";
		}
		else if(className.equals("TestScripts_Sprint01.Offers_Gamer_Tests")) {
			category = "Gamer | Offers";
		}
		else if(className.equals("TestScripts_Sprint01.LinkGames_Gamer_Tests")) {
			category = "Gamer | Link Games";
		}
		else if(className.equals("TestScripts_Sprint02.EditProfile_Gamer_test")) {
			category = "Gamer | Edit Profile";
		}
		else if(className.equals("TestScripts_Sprint02.MyRewards_Gamer_Tests")) {
			category = "Gamer | My Rewards";
		}
		else if(className.equals("TestScripts_Sprint02.Redeem_Gamer_test")) {
			category = "Gamer | Redeem";
		}
		else if(className.equals("TestScripts_Sprint02.Exchange_Gamer_Tests")) {
			category = "Gamer | Exchange";
		}
		else if(className.equals("TestScripts_Sprint03.EditAccount_Cashback_test")) {
			category = "Gamer | Edit Account Cashback";
		}
		else if(className.equals("TestScripts_Sprint03.Redeem_Cashback_test")) {
			category = "Gamer | Redeem Cashback";
		}
		else if(className.equals("TestScripts_Sprint03.Premium_Gamer_Tests")) {
			category = "Gamer | Premium";
		}
		else if(className.equals("TestScripts_Sprint03.Notifications_Gamer_Tests")) {
			category = "Gamer | Notifications";
		}
		else if(className.equals("TestScripts_Sprint03.FAQsAndServerVersion_Gamer_Tests")) {
			category = "Gamer | FAQsAndServerVersion";
		}
		else if(className.equals("TestScripts_Sprint04.SignIn_Partner_Test")) {
			category = "Partner | SignInPartner";
		}
		else if(className.equals("TestScripts_Sprint04.SignIn_Admin_test")) {
			category = "Admin | SignInAdmin";
		}
		else if(className.equals("TestScripts_Sprint04.SignUp_CreateAccount_Partner_Test")) {
			category = "Partner | CreateAccount";
		}
		else if(className.equals("TestScripts_Sprint04.Forgot_Password_Admin_test")) {
			category = "Admin | ForgotPassword";
		}
		else if(className.equals("TestScripts_Sprint04.Forgot_Password_Partner_test")) {
			category = "Partner | ForgotPassword";
		}
		else if(className.equals("TestScripts_Sprint04.Admin_Users_Test")) {
			category = "Admin | AdminUsers1";
		}
		else if(className.equals("TestScripts_Sprint04.AdminUsers_Admin_Tests")) {
			category = "Admin | AdminUsers2";
		}
		else if(className.equals("TestScripts_Sprint05.Change_Password_Admin_Tests")) {
			category = "Admin | Change Password";
		}
		else if(className.equals("TestScripts_Sprint05.Change_Password_Partner_Tests")) {
			category = "Partner | Change Password";
		}
		else if(className.equals("TestScripts_Sprint05.Edit_Profile_Partner_Tests")) {
			category = "Partner | Edit Profile";
		}
		else if(className.equals("TestScripts_Sprint05.ApprovePartner_Admin_Tests")) {
			category = "Admin | Partner Approve";
		}
		else if(className.equals("TestScripts_Sprint05.PendingAndAmmendmentsSuggestedPartnerStatus_Admin_Tests")) {
			category = "Admin | Pending/Amendment Suggest Features";
		}
		else if(className.equals("TestScripts_Sprint05.Admin_Partners_Test")) {
			category = "Admin | Partners Tab Features";
		}
		else if(className.equals("TestScripts_Sprint05.Admin_Partners_Enable_Disable_Test")) {
			category = "Admin | Partner Enable/Disable";
		}
		else if(className.equals("TestScripts_Sprint05.Admin_Partners_Reject_test")) {
			category = "Admin | Partner Reject";
		}
		else if(className.equals("TestScripts_Sprint06.ChangeEmail_Admin_Tests")) {
			category = "Admin | Email Change";
		}
		else if(className.equals("TestScripts_Sprint06.ChangeEmail_Partner_Tests")) {
			category = "Partner | Email Change";
		}
		else if(className.equals("TestScripts_Sprint06.Onboarding_Partner_Tests")) {
			category = "Partner | Onboarding";
		}
		else if(className.equals("TestScripts_Sprint06.Partner_Docusign_Test")) {
			category = "Partner | DocuSign";
		}
		else if(className.equals("TestScripts_Sprint06.Partner_Games_Test")) {
			category = "Partner | Games";
		}
		
		else {
			category = "Miscellaneous";
		}
		
		return category;
	}
	
}