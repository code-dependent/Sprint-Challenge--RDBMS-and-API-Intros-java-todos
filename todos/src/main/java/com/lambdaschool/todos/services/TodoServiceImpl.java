package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodoServiceImpl implements TodosService
{
    @Autowired
    private TodoRepository todorepos;

    @Override
    public Todo save(Todo todo)
    {
        return null;
    }

    @Transactional
    @Override
    public void markComplete(long todoid)
    {

        Todo rtn = todorepos.findById(todoid)
                .orElseThrow(()-> new EntityNotFoundException("Todo ID "+ todoid +" Not Found..."));
        rtn.setCompleted(true);
        todorepos.save(rtn);
    }

}
