#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
#include <stdlib.h>
#include "EmeraldRuins.h"
using namespace std;

int main() {
	srand(time(NULL));

	string weaponChoices[3] = { "elven.bow", "ebony.mace", "dwarven.greatsword" };

	string weaponChoice = "";
	string partThreeChoice = "", partThreeAChoice = "", partThreeBChoice = "";
	string partFourChoice = "", partSixChoice = "";

	int threeBIOutcome = 0;

	int myHealth = 100;

	EmeraldRuins::displayIntroMessage();

	weaponChoice = EmeraldRuins::calculateStoryPartTwo(weaponChoices);

	cout << "\n" << "Cautiously, you proceed further into the ruins. " << "\n";
	cout << "The path branches, but which way will you go? (Choose 'left' or ";
	cout << "'right'): ";

	cin >> partThreeChoice;
	if (partThreeChoice == "left") {
		cout << "\n" << "You come to a room with two levers. " << "\n";
		cout << "There appears to be no way out, and backtracking is too ";
		cout << "easy, so you must pull one. " << "\n" << "Which will lead ";
		cout << "you to good fortune? (Choose 'left' or 'right'): ";
		cin >> partThreeAChoice;
		if (partThreeAChoice == "left") {
			cout << "\n" << "A hidden path opens up which leads to a treasure room. ";
			cout << "\n" << "Emeralds and septims fill the chests. " << "\n";
			cout << "You fill your pockets and exit the ruins. ";
			EmeraldRuins::displayFailMessage();
		}
		else if (partThreeAChoice == "right") {
			cout << "\n" << "The floor falls out from under you, and you land in ";
			cout << "a pit of spikes. " << "\n";
			EmeraldRuins::displayFailMessage();
		}
		else {
			cout << "You have entered an incorrect option.";
			EmeraldRuins::displayFailMessage();
		}
	}
	else if (partThreeChoice == "right") {
		cout << "\n" << "Following the path, you come to a room with a ";
		cout << "restless draugr sleeping in its crypt. " << "\n";
		cout << "You can either sneak past it or fight it. " << "\n";
		cout << "What course of action will you take? (Choose 'sneak' or ";
		cout << "'fight'): ";
		cin >> partThreeBChoice;
		if (partThreeBChoice == "sneak") {
			threeBIOutcome = srand() % 2;
			if (threeBIOutcome == 1) {
				cout << "\n" << "You are successful! " << "\n";
				cout << "You proceed further into the cave. " << "\n";
			}
			else {
				cout << "\n" << "You are unsuccessful and the restless draugr ";
				cout << "engages you in combat. " << "\n";
				myHealth = EmeraldRuins::calculateFightingLogic(myHealth, weaponChoice);
			}
		}
		else if (partThreeBChoice == "fight") {
			cout << "\n" << "You decide to fight the restless draugr. " << "\n";
			myHealth = EmeraldRuins::calculateFightingLogic(myHealth, weaponChoice);
		}
		else {
			cout << "You have entered an incorrect option.";
			EmeraldRuins::displayFailMessage();
		}
	}
	else {
		cout << "You have entered an incorrect option.";
		EmeraldRuins::displayFailMessage();
	}

	cout << "\n" << "The next room has a draugr scourge lurking within, but there ";
	cout << "is no chance to sneak past it this time. " << "\n" << "Do you engage in ";
	cout << "combat or turn back? (Choose 'fight' or 'flee'): ";
	cin >> partFourChoice;
	if (partFourChoice == "fight") {
		cout << "You choose to battle the draugr! " << "\n";
		myHealth = EmeraldRuins::calculateFightingLogic(myHealth, weaponChoice);
	}
	else if (partFourChoice == "flee") {
		EmeraldRuins::displayFailMessage();
	}
	else {
		cout << "You have entered an incorrect option.";
		EmeraldRuins::displayFailMessage();
	}

	myHealth = EmeraldRuins::calculateStoryPartFive(myHealth);

	cout << "A draugr death overlord sits upon a throne, a pile of emeralds ";
	cout << "by his side. " << "\n" << "Is the sight too much to bear or do ";
	cout << "you engage in your final battle of the day? (Choose 'giveup' or ";
	cout << "'endthis'): ";
	cin >> partSixChoice;
	if (partSixChoice == "giveup") {
		EmeraldRuins::displayFailMessage();
	}
	else if (partSixChoice == "endthis") {
		EmeraldRuins::calculateBossFightingLogic(myHealth, weaponChoice);
	}
	else {
		cout << "\nYou have entered an incorrect option.";
		EmeraldRuins::displayFailMessage();
	}

	system("pause");
	return 0;
}