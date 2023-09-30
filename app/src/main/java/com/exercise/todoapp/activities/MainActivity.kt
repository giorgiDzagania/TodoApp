package com.exercise.todoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import com.exercise.todoapp.Data.Note
import com.exercise.todoapp.adapter.NoteAdapter
import com.exercise.todoapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var notes: ArrayList<Note>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notes = getNote()

        binding.search.addTextChangedListener {text ->
            filterNote(text.toString())
            noteAdapter = NoteAdapter(notes)
        }
        prepareRecyclerView()

    }

    fun filterNote(query: String){
        val filteredNotes = ArrayList<Note>()
        for (note in notes){
            if (note.title.contains(query, ignoreCase = true)||
                note.content.any { it.contains(query,ignoreCase = true) } ){
                filteredNotes.add(note)
            }
        }
        notes.clear()
        notes.addAll(filteredNotes)
    }

    fun prepareRecyclerView(){
        val notes = getNote()
        noteAdapter = NoteAdapter(notes)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
            adapter = noteAdapter
        }
    }

    private fun getNote(): ArrayList<Note>{
        val note = arrayListOf<Note>()

        val content = mutableListOf<String>("someText", "learn coding" ,"movies")

        val note1 = Note(0, "firstNote", content)
        val note2 = Note(1, "grotesqueries", content)
        val note3 = Note(2, "movie", content)
        val note4 = Note(3, "learn coding", content)
        val note5 = Note(4, "work", content)
        val note6 = Note(5, "dancing", content)
        val note7 = Note(6, "see relatives", content)
        val note8 = Note(7, "Go with friends", content)
        val note9 = Note(8, "saturday", content)
        val note10 = Note(9,"rest", content)

        note.add(note1)
        note.add(note2)
        note.add(note3)
        note.add(note4)
        note.add(note5)
        note.add(note6)
        note.add(note7)
        note.add(note8)
        note.add(note9)
        note.add(note10)
        return note
    }
}