# Contact Management Application - ContactSphere

**ContactSphere** is a web application that allows users to manage their contacts in an organized and efficient manner. It centralizes the storage and retrieval of contact information, enabling users to update, store, and manage their contacts securely. The application includes essential features such as login/registration with email OTP verification, cloud storage for contact photos, and OAuth integration.

## Features

- **User Registration and Login**
  - Users can register by verifying their email through OTP.
  - OAuth integration for login via Google.
  
- **Manage Contacts**
  - Add, update, view, and delete contacts.
  - Upload contact photos and store them in cloud storage.
  
- **User Dashboard**
  - View all contacts in a single dashboard.
  - Search for specific contacts using search functionality.
  
- **Security**
  - Encrypted user data and secure authentication.
  - Role-based access control.

- **Profile Management**
  - Users can view and update their profiles.
  - View details of each contact.

## Technology Stack

- **Backend**: Spring Boot (Java)
- **Frontend**: Thymeleaf, HTML, CSS, JavaScript
- **Database**: MySQL
- **Security**: Spring Security, OAuth2

## Project Structure

CONTACT MANAGEMENT APP/
- src/
  - main/
    - java/com/contactmanager/contact/    # Java source files
    - resources/
      - static/                               # Static files like CSS, JavaScript, images
      - templates/                            # Thymeleaf HTML files
      - application.properties                # Configuration properties
  - test/                                      # Test cases
- pom.xml                                      # Maven configuration
- README.md                                    # Project documentation



## Setup Instructions

### Prerequisites

- Java 21 or later
- Maven
- MySQL
- AWS account for cloud storage (or other cloud services)

### Steps to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/PoojaHasda/smart-contact-manager.git
2. Set up MySQL:
- Create a database named contactmanagement.
- Update the MySQL connection details in src/main/resources/application.properties.
