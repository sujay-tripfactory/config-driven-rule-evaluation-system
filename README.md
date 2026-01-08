# Config Rule-Driven Evaluation System

A **Java + Maven based rule-engine project** that dynamically evaluates rules defined in **JSON configuration files**.  
This system is designed to **separate business rules from code**, making rule updates easy without code changes.

---

## 📌 Why this project?

In real backend systems (visa checks, eligibility engines, validations, workflows):

- Rules change frequently
- Hardcoding logic is risky
- Configuration-driven systems are preferred

This project demonstrates a **config-based rule evaluation engine** using **Core Java** and **Jackson (JSON processing)**.

---

## 🧠 What this system does

- Reads rule definitions from a **JSON file**
- Converts them into **Java rule objects**
- Evaluates rules dynamically
- Produces decisions based on input data
- No hardcoded conditions in code

---



---

## ⚙️ Technologies Used

- **Java 17**
- **Maven**
- **Jackson Databind** (JSON parsing)
- **Object-Oriented Design**
- **Config-driven architecture**

---

## 📄 Rule Configuration (JSON)

Rules are defined in a JSON file (example):

```json
{
  "rules": [
    {
      "ruleId": "AGE_CHECK",
      "field": "age",
      "operator": ">=",
      "value": 18,
      "result": "ELIGIBLE"
    }
  ]
}

## 🏗 Project Structure

