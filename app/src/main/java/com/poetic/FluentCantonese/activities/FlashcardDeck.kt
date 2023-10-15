package com.poetic.FluentCantonese.activities

import com.poetic.FluentCantonese.tools.Flashcard


class FlashcardDeck(lessonNumber: Int) {
    private val flashcards: MutableList<Flashcard>

    init {
        flashcards = ArrayList()
        // Popola la lista delle flashcard in base al numero di lezione selezionato
        populateFlashcards(lessonNumber)
    }

    private fun populateFlashcards(lessonNumber: Int) {
        // Implementa la logica per popolare la lista delle flashcard in base al numero di lezione
        // Qui potresti avere delle condizioni o un'altra logica per selezionare le flashcard corrette
        // In questo esempio, verranno utilizzate alcune flashcard di esempio
        when (lessonNumber) {
            1 -> {
                flashcards.add(Flashcard("Hello", "你好", "nei5 hou2"))
                flashcards.add(Flashcard("Goodbye", "再見", "zoi3 gin3"))
            }

            2 -> {
                flashcards.add(Flashcard("Sorry", "對唔住", "deoi3 m4 zyu6"))
                flashcards.add(Flashcard("Please", "唔該", "m4 goi1"))
            }

            else ->                 // Se il numero di lezione non corrisponde a nessuna condizione, aggiungi flashcard di default
                flashcards.add(Flashcard("Default Front", "Default Back", "Default Pronunciation"))
        }
    }

    fun getFlashcards(): List<Flashcard> {
        return flashcards
    }
}
