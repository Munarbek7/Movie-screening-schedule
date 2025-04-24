#  Movie Screening Schedule Manager

## Student Name:
Munarbek Makhkambaev

##  Description:
A Java-based command-line application to manage movie screening schedules. It allows users to perform CRUD (Create, Read, Update, Delete) operations with persistent data storage using files.

##  Objectives:
- Build a Java application using core programming concepts.
- Implement CRUD operations for managing movie records.
- Ensure data persistence using file handling.
- Provide a command-line interface for interaction.
- Validate user input to prevent incorrect data.

##  Project Requirement List:
1. Add a new movie schedule (Create).
2. View all scheduled movies (Read).
3. Update an existing movie's details.
4. Delete a movie by ID.
5. Validate empty inputs.
6. Store data in a file for persistence.
7. Load data from file on startup.
8. Use classes and objects (OOP).
9. Use ArrayList for storing movies.
10. Handle file read/write exceptions.

##  Documentation:
- **Classes**: `Movie` (data model), `MovieManager` (logic), `MovieApp` (UI & main).
- **Data Structures**: `ArrayList<Movie>` is used to manage records in memory.
- **File Handling**: Uses `ObjectOutputStream` and `ObjectInputStream` to write/read binary file `movies.txt`.
- **Methods**: Modular methods for add, update, delete, list, save, load.
- **Error Handling**: Try-catch blocks for input validation and file operations.
- **Challenges**: Handling file I/O and object serialization/deserialization correctly.

##  Test Cases & Outputs:

**Test Case 1: Add Movie**
- Input: `ID: M001, Title: Avatar, Theater: Hall 1, Time: 18:00`
- Expected Output: `Movie added.`

**Test Case 2: View Movies**
- Input: `ID: M001, New Title: Avatar 2`
- Expected Output: `Movie List`

**Test Case 3: Update Movie**
- Input: `ID: M001`
- Expected Output: `Movie updated.`

**Test Case 4: Delete Movie**
- Expected Output: `Movie Deleted.`

## Files Used:
- `movies.txt`: Binary file used to store all movie objects.

## Submission Links

 Presentation & Demo:
- [Presentation Slides (Google Drive)](https://docs.google.com/presentation/d/12BRfpkM-heoDUWY-d5l5oS6qaVghPv9tB69C-s7NEQc/edit?usp=sharing)

