-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 30. Mrz 2018 um 23:18
-- Server-Version: 10.1.30-MariaDB
-- PHP-Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `fluginformationsdb`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `buchung`
--

CREATE TABLE `buchung` (
  `BuchungsID` int(11) NOT NULL,
  `PassagierID` int(11) NOT NULL,
  `FlugID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `buchung`
--

INSERT INTO `buchung` (`BuchungsID`, `PassagierID`, `FlugID`) VALUES
(1, 1, 2),
(2, 2, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `flug`
--

CREATE TABLE `flug` (
  `FlugID` int(11) NOT NULL,
  `Startzeit` datetime NOT NULL,
  `Ankunftszeit` datetime NOT NULL,
  `LinieID` int(11) NOT NULL,
  `FlugzeugID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `flug`
--

INSERT INTO `flug` (`FlugID`, `Startzeit`, `Ankunftszeit`, `LinieID`, `FlugzeugID`) VALUES
(1, '2018-03-31 10:44:00', '2018-03-31 13:22:00', 1, 1),
(2, '2018-03-31 13:28:00', '2018-03-31 23:55:00', 4, 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `flughafen`
--

CREATE TABLE `flughafen` (
  `FlughafenID` int(11) NOT NULL,
  `IataCode` varchar(3) NOT NULL,
  `Stadt` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `flughafen`
--

INSERT INTO `flughafen` (`FlughafenID`, `IataCode`, `Stadt`) VALUES
(1, 'FMO', 'Münster/ Osnabrück'),
(2, 'TXL', 'Berlin-Tegel'),
(3, 'ATH', 'Athen'),
(4, 'JFK', 'New York');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `fluglinie`
--

CREATE TABLE `fluglinie` (
  `FluglinieID` int(11) NOT NULL,
  `StartortID` int(11) NOT NULL,
  `ZielortID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `fluglinie`
--

INSERT INTO `fluglinie` (`FluglinieID`, `StartortID`, `ZielortID`) VALUES
(1, 1, 3),
(2, 1, 2),
(3, 2, 4),
(4, 4, 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `flugzeug`
--

CREATE TABLE `flugzeug` (
  `FlugzeugID` int(11) NOT NULL,
  `FlugzeugtypID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `flugzeug`
--

INSERT INTO `flugzeug` (`FlugzeugID`, `FlugzeugtypID`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `flugzeugtyp`
--

CREATE TABLE `flugzeugtyp` (
  `FlugzeugtypID` int(11) NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Kapazität` int(11) NOT NULL,
  `Reichweite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `flugzeugtyp`
--

INSERT INTO `flugzeugtyp` (`FlugzeugtypID`, `Name`, `Kapazität`, `Reichweite`) VALUES
(1, 'Boeing 747-8', 467, 9800),
(2, 'Airbus A380', 853, 15700);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `mahlzeit`
--

CREATE TABLE `mahlzeit` (
  `MahlzeitID` int(11) NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Beschreibung` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `mahlzeit`
--

INSERT INTO `mahlzeit` (`MahlzeitID`, `Name`, `Beschreibung`) VALUES
(1, 'Pizza', 'italienische Spezialität'),
(2, 'Burger', 'amerikanischer Art');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `passagier`
--

CREATE TABLE `passagier` (
  `PassagierID` int(11) NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Nachname` varchar(32) NOT NULL,
  `Geburtsdatum` date NOT NULL,
  `Ort` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `passagier`
--

INSERT INTO `passagier` (`PassagierID`, `Name`, `Nachname`, `Geburtsdatum`, `Ort`) VALUES
(1, 'Frederik', 'Schulte', '2018-03-29', 'Münster'),
(2, 'Josef', 'Bergmannn', '1997-04-12', 'Spelle');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `speisekarte`
--

CREATE TABLE `speisekarte` (
  `FlugID` int(11) NOT NULL,
  `MahlzeitID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `speisekarte`
--

INSERT INTO `speisekarte` (`FlugID`, `MahlzeitID`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `Benutzername` varchar(32) NOT NULL,
  `Passwort` varchar(256) NOT NULL,
  `Rolle` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`userID`, `Benutzername`, `Passwort`, `Rolle`) VALUES
(1, 'MiarbeiterMustermann', 'musterpasswortMussNochGehashtWerden', 'Mitarbeiter'),
(2, 'Boss', 'BossHashFehlt', 'Manager');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `buchung`
--
ALTER TABLE `buchung`
  ADD PRIMARY KEY (`BuchungsID`),
  ADD KEY `PassagierID` (`PassagierID`),
  ADD KEY `FlugID` (`FlugID`);

--
-- Indizes für die Tabelle `flug`
--
ALTER TABLE `flug`
  ADD PRIMARY KEY (`FlugID`),
  ADD KEY `LinieID` (`LinieID`),
  ADD KEY `FlugzeugID` (`FlugzeugID`);

--
-- Indizes für die Tabelle `flughafen`
--
ALTER TABLE `flughafen`
  ADD PRIMARY KEY (`FlughafenID`);

--
-- Indizes für die Tabelle `fluglinie`
--
ALTER TABLE `fluglinie`
  ADD PRIMARY KEY (`FluglinieID`),
  ADD KEY `StartortID` (`StartortID`),
  ADD KEY `ZielortID` (`ZielortID`);

--
-- Indizes für die Tabelle `flugzeug`
--
ALTER TABLE `flugzeug`
  ADD PRIMARY KEY (`FlugzeugID`),
  ADD KEY `FlugzeugtypID` (`FlugzeugtypID`);

--
-- Indizes für die Tabelle `flugzeugtyp`
--
ALTER TABLE `flugzeugtyp`
  ADD PRIMARY KEY (`FlugzeugtypID`);

--
-- Indizes für die Tabelle `mahlzeit`
--
ALTER TABLE `mahlzeit`
  ADD PRIMARY KEY (`MahlzeitID`);

--
-- Indizes für die Tabelle `passagier`
--
ALTER TABLE `passagier`
  ADD PRIMARY KEY (`PassagierID`);

--
-- Indizes für die Tabelle `speisekarte`
--
ALTER TABLE `speisekarte`
  ADD KEY `FlugID` (`FlugID`),
  ADD KEY `MahlzeitID` (`MahlzeitID`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `buchung`
--
ALTER TABLE `buchung`
  MODIFY `BuchungsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `flug`
--
ALTER TABLE `flug`
  MODIFY `FlugID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `flughafen`
--
ALTER TABLE `flughafen`
  MODIFY `FlughafenID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `fluglinie`
--
ALTER TABLE `fluglinie`
  MODIFY `FluglinieID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `flugzeug`
--
ALTER TABLE `flugzeug`
  MODIFY `FlugzeugID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `flugzeugtyp`
--
ALTER TABLE `flugzeugtyp`
  MODIFY `FlugzeugtypID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `mahlzeit`
--
ALTER TABLE `mahlzeit`
  MODIFY `MahlzeitID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `passagier`
--
ALTER TABLE `passagier`
  MODIFY `PassagierID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `buchung`
--
ALTER TABLE `buchung`
  ADD CONSTRAINT `buchung_ibfk_1` FOREIGN KEY (`PassagierID`) REFERENCES `passagier` (`PassagierID`),
  ADD CONSTRAINT `buchung_ibfk_2` FOREIGN KEY (`FlugID`) REFERENCES `flug` (`FlugID`);

--
-- Constraints der Tabelle `flug`
--
ALTER TABLE `flug`
  ADD CONSTRAINT `flug_ibfk_1` FOREIGN KEY (`LinieID`) REFERENCES `fluglinie` (`FluglinieID`),
  ADD CONSTRAINT `flug_ibfk_2` FOREIGN KEY (`FlugzeugID`) REFERENCES `flugzeug` (`FlugzeugID`);

--
-- Constraints der Tabelle `fluglinie`
--
ALTER TABLE `fluglinie`
  ADD CONSTRAINT `fluglinie_ibfk_1` FOREIGN KEY (`ZielortID`) REFERENCES `flughafen` (`FlughafenID`),
  ADD CONSTRAINT `fluglinie_ibfk_2` FOREIGN KEY (`StartortID`) REFERENCES `flughafen` (`FlughafenID`);

--
-- Constraints der Tabelle `flugzeug`
--
ALTER TABLE `flugzeug`
  ADD CONSTRAINT `flugzeug_ibfk_1` FOREIGN KEY (`FlugzeugtypID`) REFERENCES `flugzeugtyp` (`FlugzeugtypID`);

--
-- Constraints der Tabelle `speisekarte`
--
ALTER TABLE `speisekarte`
  ADD CONSTRAINT `speisekarte_ibfk_1` FOREIGN KEY (`FlugID`) REFERENCES `flug` (`FlugID`),
  ADD CONSTRAINT `speisekarte_ibfk_2` FOREIGN KEY (`MahlzeitID`) REFERENCES `mahlzeit` (`MahlzeitID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
