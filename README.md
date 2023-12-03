# Saúde Presença - API Test
Welcome to the repository for API tests using Rest Assured for the Health Presence System. This project is developed as part of the Master's in Software Engineering program.

### Introduction
This repository contains automated API tests using Rest Assured for the Saúde Presença. These tests are designed to ensure the reliability and functionality of the system's API. The project is developed as a part of the Master's in Software Engineering program.

### Dependencies
The project is built using Java and utilizes various dependencies managed by Gradle.

## How to Use
Follow the steps below to set up and execute the API tests:

Clone the Repository:

```
git clone https://github.com/your-username/health-presence-api-tests.git
cd health-presence-api-tests
```

### Set environment variables:
Create a .env file in the root of the project and configure the required environment variables.

Example .env file:
```
API_BASE_URL=https://example.com
USERNAME=your_username
PASSWORD=your_password
```

### Run all Tests:

```
./gradlew test
```

This command will execute the API tests, and the results will be displayed in the console.

### Review the reports:
After running the tests, you can find detailed test reports in the build/reports/tests/test directory.

### Customize:
Feel free to customize and expand this project based on your testing needs. You can add more test cases, extend the test scenarios, or integrate with other testing tools.

### Contributions
If you encounter issues or have suggestions for improvements, feel free to open an issue or submit a pull request. Contributions are welcome, and collaboration enhances the quality of the test suite.

### License
This project is licensed under the MIT License - see the LICENSE file for details.