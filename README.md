# Hotel-Reservations-Modifier
The Hotel Reservation Application is a Java GUI Swing application that allows users to make hotel reservations. The application consists of three pages and incorporates multiprocessing and multithreading for enhanced performance.

## Features

- **Page 1: Main Page**
    - Displays "Hotel Reservations" at the top.
    - Text fields for name and ID.
    - Select boxes for arrival date and leave date.
    - Next button to navigate to the second page.

- **Page 2: Doors Page**
    - Displays 20 doors dynamically.
    - Random availability of doors (some selectable, some not).
    - Users can select one or more doors.
    - Next button to navigate to the third page.

- **Page 3: Confirmation Page**
    - Displays a thank you message for using the app.
    - Shows the selected arrival date and leave date.

## Multiprocessing and Multithreading

The application utilizes multiprocessing and multithreading to enhance performance and responsiveness. Specifically:

- Multiprocessing: The application creates multiple processes to handle time-consuming tasks in the background while keeping the GUI responsive.

- Multithreading: Threads are used to perform concurrent operations, such as handling user interaction and updating the GUI components.

## Getting Started

To run the Hotel Reservation Application on your local machine, follow these steps:

1. Clone the repository.

2. Open the project in your preferred Java IDE.

3. Build and run the application.

## Dependencies

The Hotel Reservation Application has the following dependencies:

- Java Development Kit (JDK) 8 or higher
- Java Swing library

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.