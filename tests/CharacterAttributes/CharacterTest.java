package CharacterAttributes;

import Characters.CharacterType;
import Characters.RPGCharacter;
import Characters.Warrior;
import Functionality.CreateCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterTest {


    // new character level should be 1
    @Test
    public void createCharacterShouldBeLevel0ne_valid_shouldpass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        assertEquals(1, warrior.getLevel());
    }

    // level up 1 level
    @Test
    public void characterLevelPlusOne_valid_shouldpass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        warrior.levelUp(1);
        assertEquals(2, warrior.getLevel());
    }


    // levelling up with 0
    @Test
    public void characterGainZeroLevelisCaught_invalid_shouldpass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        try{
            warrior.levelUp(0);
        }catch (IllegalArgumentException e){
            String message = "Level must be greater than zero";
            assertEquals(message, e.getMessage());
        }
    }

    // correct stats when created
    @Test
    public void warriorCreatedWithCorrectStats_valid_shouldpass(){
        RPGCharacter character = CreateCharacter.createChar(4);
        assertEquals(10, character.getVitality());
        assertEquals(5, character.getStrength());
        assertEquals(2, character.getDexterity());
        assertEquals(1, character.getIntelligence());
    }


    @Test
    public void rogueCreatedWithCorrectStats_valid_shouldpass(){
        RPGCharacter character = CreateCharacter.createChar(3);
        assertEquals(8, character.getVitality());
        assertEquals(2, character.getStrength());
        assertEquals(6, character.getDexterity());
        assertEquals(1, character.getIntelligence());
    }

    @Test
    public void rangerCreatedWithCorrectStats_valid_shouldpass(){
        RPGCharacter character = CreateCharacter.createChar(2);
        assertEquals(8, character.getVitality());
        assertEquals(1, character.getStrength());
        assertEquals(7, character.getDexterity());
        assertEquals(1, character.getIntelligence());
    }

    @Test
    public void mageCreatedWithCorrectStats_valid_shouldpass(){
        RPGCharacter character = CreateCharacter.createChar(1);
        assertEquals(5, character.getVitality());
        assertEquals(1, character.getStrength());
        assertEquals(1, character.getDexterity());
        assertEquals(8, character.getIntelligence());
    }

    // correct stats when level up
    @Test
    public void warriorCorrectLevelUp_valid_shouldpass(){
        RPGCharacter character = CreateCharacter.createChar(4);
        character.levelUp(1);
        assertEquals(15, character.getVitality());
        assertEquals(8, character.getStrength());
        assertEquals(4, character.getDexterity());
        assertEquals(2, character.getIntelligence());
    }


    @Test
    public void rogueCorrectLevelUp_valid_shouldpass(){
        RPGCharacter character = CreateCharacter.createChar(3);
        character.levelUp(1);
        assertEquals(11, character.getVitality());
        assertEquals(3, character.getStrength());
        assertEquals(10, character.getDexterity());
        assertEquals(2, character.getIntelligence());
    }

    @Test
    public void rangerCorrectLevelUp_valid_shouldpass(){
        RPGCharacter character = CreateCharacter.createChar(2);
        character.levelUp(1);
        assertEquals(10, character.getVitality());
        assertEquals(2, character.getStrength());
        assertEquals(12, character.getDexterity());
        assertEquals(2, character.getIntelligence());
    }

    @Test
    public void mageCorrectLevelUp_valid_shouldpass(){
        RPGCharacter character = CreateCharacter.createChar(1);
        character.levelUp(1);
        assertEquals(8, character.getVitality());
        assertEquals(2, character.getStrength());
        assertEquals(2, character.getDexterity());
        assertEquals(13, character.getIntelligence());
    }


    // secondary stats
    @Test
    public void secondaryStatsOnLevelUp_valid_shouldpass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        warrior.levelUp(1);
        assertEquals(150, warrior.getHealth());
        assertEquals(12, warrior.getArmorRating());
        assertEquals(2, warrior.getElementalResistance());
    }
}
