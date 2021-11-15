# SendGridConnector
A Mendix wrapper for using the SendGrid API

## How to Send an Email
Follow the directions below to start sending emails.

### 1. Signup with SendGrid
Sign up with [SendGrid](https://www.sendgrid.com) and configure your authorized sender in the SendGrid portal.

### 2. Set the API Key
Make sure to create an API key in SendGrid. Set the API Key constant in the Mendix Sendgrid connector module.

### 3. Create and send an email object
Use the micrflows located in the `_Use_me` folder to construct an email. Make sure to specify your authorized sender in the `from` address. 

- `CreateMail` to create a mail object of which you can change the attributes.
- `SendMail` to request SendGrid to send an email.

Look at one of the example microflows how to set up an email.

## How to receive email events
Follow the directions below to track email status.

### 1. Configure your SendGrid account
Make sure you have enabled the webhook function in SendGrid.

### 2. Include the AfterStartup microflows
Copy and move the `AfterStartup` and `EventHandlerExample` to one of the modules in your project or create a new module.

### 2. Include the SendGrid Published REST Service 
Copy and move the `SendGridService` Published REST Service to one of the modules in your project or create a new module.

### 3. (Optional) Enable receiving signed webhook events
To make sure SendGrid is the sender of a request you can enable verification of the signature.

Set the `SignatureValidationEnabled` constant value to `true`.
Set the `VerificationKey` value which can be created on the SendGrid website.