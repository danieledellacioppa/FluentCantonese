package com.poetic.FluentCantonese.activities;

import com.poetic.FluentCantonese.tools.Flashcard;

import java.util.ArrayList;
import java.util.List;

public class FlashcardDeck {
    private List<Flashcard> flashcards;

    public FlashcardDeck(int lessonNumber) {
        flashcards = new ArrayList<>();
        // Popola la lista delle flashcard in base al numero di lezione selezionato
        populateFlashcards(lessonNumber);
    }

    private void populateFlashcards(int lessonNumber) {
        // Implementa la logica per popolare la lista delle flashcard in base al numero di lezione
        // Qui potresti avere delle condizioni o un'altra logica per selezionare le flashcard corrette
        // In questo esempio, verranno utilizzate alcune flashcard di esempio
        switch (lessonNumber) {
            case 1:
                flashcards.add(new Flashcard("Hello", "你好", "nei5 hou2"));
                flashcards.add(new Flashcard("Goodbye", "再見", "zoi3 gin3"));
                flashcards.add(new Flashcard("Sorry", "對唔住", "deoi3 m4 zyu6"));
                flashcards.add(new Flashcard("Please", "唔該", "m4 goi1"));
                flashcards.add(new Flashcard("I", "我", "ngo5"));
                flashcards.add(new Flashcard("You", "你", "nei5"));
                flashcards.add(new Flashcard("He", "佢", "keoi5"));
                flashcards.add(new Flashcard("She", "佢", "keoi5"));
                flashcards.add(new Flashcard("We", "我哋", "ngo5 dei6"));
                flashcards.add(new Flashcard("They", "佢哋", "keoi5 dei6"));
                flashcards.add(new Flashcard("This", "呢個", "ni1 go3"));
                flashcards.add(new Flashcard("That", "嗰個", "go2 go3"));
                flashcards.add(new Flashcard("Here", "呢度", "ni1 dou6"));
                break;

            case 2:
                flashcards.add(new Flashcard("Sorry", "對唔住", "deoi3 m4 zyu6"));
                flashcards.add(new Flashcard("Please", "唔該", "m4 goi1"));
                break;

            default:
                // Se il numero di lezione non corrisponde a nessuna condizione, aggiungi flashcard di default
                flashcards.add(new Flashcard("Default Front", "Default Back", "Default Pronunciation"));
                break;
        }
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }
}
