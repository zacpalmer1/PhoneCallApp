# PhoneCallApp
## How to use this application
- This application is not in the Google Play Store
- To run this project you must download the files above and simulate in Android Studio
##

<img width="200" alt="Screenshot 2023-03-16 at 7 32 32 PM" src="https://user-images.githubusercontent.com/75393933/225775471-c6678f9f-f2c2-4f53-8fb6-7ae94927712f.png">

## Assignment Guidlines:
Create an application that could be used to make phone calls on Android phones. For this application, you will need to check/request permissions at runtime. You should implement ActivityResultLauncher<String>, function checkPhonePermission(), and function makeCall() similar to the those outlined in the slides.
There should be one activity/screen described as follows:
1. Provide a prompt and an EditText field for entering the phone number. When the application starts, the keyboard should display with an input type of phone and the cursor in the phone EditText view; i.e., the user should not have to click or tap in the EditText view in order to bring up the keyboard.
2. There should be button below the phone EditText field labeled “Make Call”. When the user clicks on the button and the phone number field is not empty, the application should attempt to call the number listed. You should perform some error checking here.

## Above and Beyond:
### Improved UI
- Insead of allowing the user access to keyboard through EditText, I created a grid of buttons that are mapped to numbers to more closely resemble a phone application
- Implamented a simple color scheme

### Improved Functionality
- Only allowed a user to enter a 7-diget number with area code
- Created parameters so area code is in parenthesis
- Created parameters to input a "-" after the first 3 non area code digits
- Implamented a back space and clear button
