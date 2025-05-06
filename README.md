## 🥗 Calorie Calculator – MVP Architecture (Java Console Application)

A modular and maintainable Java console application implemented using the **Model-View-Presenter (MVP)** architectural style. This project is part of the assignment:
**"Implementation and Analysis of Software Architecture Styles"** under **Advanced Software Architecture**.

---

### 📦 Architecture: Model-View-Presenter (MVP)

The application follows the **MVP pattern**:

* **Model**: Contains all logic and BMR formula calculations.
* **View**: Console interface that interacts with the user.
* **Presenter**: Acts as a mediator between View and Model, enforcing separation of concerns.

---

### ✅ Key Features

* Calculates **Basal Metabolic Rate (BMR)** using gender-specific formulas.
* Adjusts calorie needs based on activity level:

  * Sedentary
  * Moderate
  * Active
* Modular design using MVP for **separation of concerns**.
* Input validation for user reliability.
* Easily extendable and testable architecture.
* CLI-based interface, suitable for beginner or educational use.

---

### 🧪 Non-Functional Requirements

* **Reliability**: Input validation and fault tolerance mechanisms.
* **Scalability**: MVP structure makes it easy to extend for GUI/web versions.
* **Robustness**: Isolated business logic ensures fault-free computation.

---

### ⚙️ Technologies Used

* **Java** (JDK 8+)
* **Java Scanner** for input
* **Command-Line Interface**
* **Unit Testing** (Optional but recommended via JUnit)

---

### 📁 Getting Started

```bash
# Check Java version
java -version

# Compile the application
javac App.java

# Run the application
java App
```

---

### 💡 Example Usage

```
Calorie Calculator
Enter your gender (M/F): M
Enter your age (in years): 21
Enter your weight (in kilograms): 70
Enter your height (in centimeters): 175
Enter your activity level (sedentary/moderate/active): moderate

Your Basal Metabolic Rate (BMR) is: 1723 calories per day.
Your estimated daily calorie needs are: 2671 calories per day.
```

---

### 🧮 BMR Formula Reference

* **Men**:
  `BMR = 88.362 + (13.397 × weight) + (4.799 × height) − (5.677 × age)`

* **Women**:
  `BMR = 447.593 + (9.247 × weight) + (3.098 × height) − (4.330 × age)`

* **Activity Multipliers**:

  * Sedentary: × 1.2
  * Moderate: × 1.55
  * Active: × 1.725

---

### 🧱 MVP Components

* `Model.java` – Contains calculation logic
* `View.java` – Handles user input/output
* `Presenter.java` – Orchestrates data flow between Model and View
* `App.java` – Main entry point

---

### 📊 UML Diagram & Report

Refer to the attached report and UML diagrams for:

* MVP structure and responsibilities
* Flow of data and control
* Comparative analysis with other architectural styles
* How this implementation supports **reusability**, **scalability**, and **reliability**

---

### 📝 Submission Includes

* ✅ Modular, well-documented codebase
* ✅ Comparative report (PDF/Word)
* ✅ UML diagrams (Class + Interaction)
* ✅ (Optional) Unit tests
* ✅ (Optional) Presentation slides

---

> 🔐 *This project is developed for educational purposes as part of a software architecture assignment. Feel free to fork, explore, and extend!*

---

Would you like a sample UML diagram to include with this GitHub project?
