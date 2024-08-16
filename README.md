# techsupportbot

Übersicht

TechSupportBot ist eine Spring Boot-basierte Webanwendung, die als Basis für einen Tech-Support-Bot dient. Die Anwendung beinhaltet grundlegende Funktionen wie Benutzerverwaltung, Authentifizierung, Passwortverschlüsselung und eine einfache Webschnittstelle.
Funktionen

Benutzerverwaltung: Registrierung, Login, und Verwaltung von Benutzerdaten.
Authentifizierung: Benutzer können sich sicher anmelden, und die Anwendung unterstützt rollenbasierte Zugriffskontrolle.
Passwortverschlüsselung: Sicheres Speichern von Passwörtern mittels BCrypt.
Webschnittstelle: Einfache Webansichten für Login, Registrierung und Benutzerinteraktion.

Installation

1. Projek clonen:
   
   git clone https://github.com/username/techsupportbot.git
   cd techsupportbot
   
2. Abhängigkeiten installieren:
   
   mvn clean install

3. Anwendung starten:

   mvn spring-boot:run

Die Anwendung ist nun unter "http://localhost:25750" erreichbar.

Voraussetzungen

Java 11 oder höher
Maven 3.6 oder höher
Spring Boot 2.7 oder höher

Projektstruktur

src/main/java/com/example/techsupportbot/: Der Hauptcode der Anwendung.
config/: Konfigurationsdateien für Spring Security und andere Beans.
controller/: Spring MVC Controller, die die Web-Endpunkte der Anwendung verwalten.
model/: Die Entitäten und Modelle, die in der Anwendung verwendet werden.
repository/: Datenzugriffsschicht für die Interaktion mit der Datenbank.
service/: Geschäftslogik der Anwendung, wie Benutzerverwaltung und Authentifizierungsdienste.

src/test/java/: Testcode für die Anwendung.
controller/: Tests für die Controller.
config/: Tests für die Konfigurationen.
service/: Tests für die Geschäftslogik.

Verwendete Technologien

Spring Boot: Framework für die schnelle Entwicklung von Webanwendungen.
Spring Security: Sicherheitsframework zur Implementierung von Authentifizierung und Autorisierung.
Thymeleaf: Template-Engine zur Generierung von HTML-Seiten.
JUnit 5: Testframework für Unit- und Integrationstests.
Mockito: Framework zum Erstellen von Mock-Objekten in Tests.
