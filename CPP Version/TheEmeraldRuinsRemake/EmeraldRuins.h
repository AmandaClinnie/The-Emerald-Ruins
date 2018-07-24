#ifndef EMERALDRUINS_H
#define EMERALDRUINS_H

#include <iostream>
#include <string>
using namespace std;

class EmeraldRuins {
public:
	static void displayIntroMessage();
	static void displayFailMessage();
	static string calculateStoryPartTwo(string myArray[]);
	static int calculateFightingLogic(int &sveoHealth, string sveoWeapon);
	static int calculateStoryPartFive(int &sveoHealth);
	static void calculateBossFightingLogic(int &sveoHealth, string sveoWeapon);
};

#endif 