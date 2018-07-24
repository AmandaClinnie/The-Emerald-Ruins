#include <iostream>
#include <string>
#include <cstdlib>
#include "EmeraldRuins.h"
using namespace std;

void EmeraldRuins::displayIntroMessage() {
	cout << "Hello, and welcome to The Emerald Ruins. " << "\n";
	cout << "If you are new to Choose Your own Adventure games, ";
	cout << "the idea is pretty simple. You will be told a story and ";
	cout << "provided choices along the way (spelling and ";
	cout << "capitalization matters). Be careful though, those ";
	cout << "choices may affect the outcome of the story!" << "\n";
	cout << "Time to begin!" << "\n\n";
}

void EmeraldRuins::displayFailMessage() {
	cout << "\nYour journey ends here. Thank you for playing and ";
	cout << "please try again." << "\n";
	system("pause");
	exit(0);
}

string EmeraldRuins::calculateStoryPartTwo(string myArray[]) {
	string userInput = "";
	string weaponChoice = "";
	cout << "You are the famed adventurer Sveo Whitemane. " << "\n";
	cout << "While wandering through the forests of Falkreath ";
	cout << "Hold one day you come upon the Emerald Ruins. " << "\n";
	cout << "Do you wish to explore its depths? (Choose 'yes' or 'no'): ";
	cin >> userInput;
	if (userInput == "no") {
		displayFailMessage();
	}
	else if (userInput == "yes") {
		cout << "\n" << "You proceed inside. " << endl;
		cout << "You find a fallen adventurer with a note by his side: " << "\n";
		cout << "'Whoever enters here, be warned." << "\n";
		cout << "Draugr roam the halls - take one of these if you want to ";
		cout << "survive.'" << "\n" << "By his side lay three weapons, ";
		cout << "which will you choose? " << "\n";
		for (int i = 0; i < 3; i++) {
			cout << "'" << myArray[i] << "'";
		}
		cout << "\n";
		cin >> weaponChoice;
	}
	else {
		cout << "You have entered an incorrect option. ";
		displayFailMessage();
	}
	return weaponChoice;
}

int EmeraldRuins::calculateFightingLogic(int &sveoHealth, string sveoWeapon) {
	int sveoDamage = 0;
	int enemyHealth = 40;
	if (sveoWeapon == "elven.bow") {
		sveoDamage = 13;
	}
	else if (sveoWeapon == "ebony.mace") {
		sveoDamage = 15;
	}
	else if (sveoWeapon == "dwarven.greatsword") {
		sveoDamage = 19;
	}
	else {
		cout << "You have entered an incorrect option. ";
		displayFailMessage();
	}
	for (enemyHealth; enemyHealth > 0; enemyHealth -= sveoDamage) {
		sveoHealth -= (rand() % 30) + 1;
		if (sveoHealth <= 0) {
			displayFailMessage();
		}
	}
	cout << "You won the battle! " << "\n";
	return sveoHealth;
}

int EmeraldRuins::calculateStoryPartFive(int &sveoHealth) {
	string partFiveChoice = "";
	cout << "\n" << "The path leads into a room with barrels full of ";
	cout << "health potions. " << "\n" << "You've explored enough caves ";
	cout << "to know what this means - the boss is up ahead. " << "\n";
	cout << "Are you confident in your battle skills or do you take ";
	cout << "the potions? " << "\n" << "(Choose 'maxhealth' or ";
	cout << "'forgeahead'): ";
	cin >> partFiveChoice;
	if (partFiveChoice == "maxhealth") {
		cout << "\n" << "You choose to max out your health. " << "\n";
		sveoHealth = 100;
	}
	else if (partFiveChoice == "forgeahead") {
		cout << "\n" << "You choose not to max out your health. " << "\n";
	}
	else {
		cout << "\n" << "You have entered an incorrect option. " << "\n";
		displayFailMessage();
	}
	return sveoHealth;
}

void EmeraldRuins::calculateBossFightingLogic(int &sveoHealth, string sveoWeapon) {
	int sveoDamage = 0;
	int enemyHealth = 75;
	if (sveoWeapon == "elven.bow") {
		sveoDamage = 13;
	}
	else if (sveoWeapon == "ebony.mace") {
		sveoDamage = 15;
	}
	else if (sveoWeapon == "dwarven.greatsword") {
		sveoDamage = 19;
	}
	else {
		cout << "You have entered an incorrect option. ";
		displayFailMessage();
	}
	for (enemyHealth; enemyHealth > 0; enemyHealth -= sveoDamage) {
		sveoHealth -= (rand() % 30) + 1;
		if (sveoHealth <= 0) {
			displayFailMessage();
		}
	}
	cout << "\n" << "The battle is over, and you fill your pockets with the gems. ";
	cout << "\n" << "It wasn't easy, but another worthwhile adventure ";
	cout << "\n" << "is complete. " << "\n";
	displayFailMessage();
}