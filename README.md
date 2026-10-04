# Real Estate Agency Management System 🏠 (Java, OOP)

A console-based real estate agency system written in Java, built as a team project for an Object-Oriented Programming course. Users sign up as buyers, sellers, or renters, and a manager role handles accounts and property maintenance. Accounts and listings are saved between runs with Java serialization.

## Features

- **Accounts:** sign up and log in with an ID and password; each new user receives a generated welcome letter file.
- **Sellers:** list a property (studio, villa, apartment, or commercial) for sale, rent, or auction, and estimate monthly mortgage payments.
- **Buyers:** buy a property directly or bid in an auction.
- **Renters:** choose short-term or long-term rental and rent a property by ID.
- **Managers:** view, search, sort, and remove accounts, hire a housekeeper, and mark properties as maintained.
- **Feedback:** leave a comment, like or dislike, a 1–5 rating, and a reply.
- **Persistence:** accounts and properties are stored in `accounts.ser` and `properties.ser`.

## OOP Design

| Concept | Where it appears |
|---|---|
| Inheritance | `People` → `Buyers`, `Sellers`, `Renters`, `Managers`, `Contractors`; `Property` → `Villa`, `Appartment`, `Studio`, `Commercial` |
| Abstraction | Abstract class `Sale` → `BuyNow`, `Auction`, `Mortgage` |
| Encapsulation | Private and protected fields accessed through getters and setters |
| Enums | `Occupation`, `typeOfHousing`, `SaleType`, `TransactionType`, `Status` |
| Interfaces | `Serializable` for persistence, `Comparator` for sorting |

## Project Structure

```
src/
├── main/          # Entry point, menus, accounts, serialization
├── housing/       # Property and its subclasses
├── individuals/   # People and their roles, comments
└── transaction/   # Sales, auctions, mortgages, rentals, payments
```

## Build and Run

Requires Java 21 or later (JDK). From the project folder:

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out main.Main
```

On Windows PowerShell:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out main.Main
```

You can also open the folder as a project in NetBeans and click Run.

## Known Limitations

This is the original course version, kept as the team submitted it. Known issues:

- Saving fails once properties exist, because `Property` does not implement `Serializable`.
- Account IDs restart from 1 after a restart, since the static counter is not saved.
- Buy Now closes the shared input stream, so later prompts fail.
- The manager menu checks the wrong variable, so remove, hire, and maintain do not run.
- Rental listing and price sorting methods in the menu are not implemented yet.

## Team

Team project for the Object-Oriented Programming course at Al Akhawayn University in Ifrane, built by Saad, Ilyas Ezzahrioui, Maroua, and Ouzair Bouaouida.

Ouzair Bouaouida built the `transaction` package (sales, buy now, auctions, mortgages, payments, transactions).
