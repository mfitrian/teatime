package com.fiteatime.teatime.rest;

import com.fiteatime.teatime.models.Tea;
import com.fiteatime.teatime.dto.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RestController
public class TeaController {

    @Autowired
    TeaRepository teaRepository;

    //GODLLY; show off!!!! Gets the job done, dont know that it does but it returns what I wasnt
    @RequestMapping(method=RequestMethod.GET, path="/tea")
    public List<Tea> GetAllTea() {
        Iterator<Tea> source = teaRepository.findAll().iterator();
        List<Tea> teaList = new ArrayList();
        source.forEachRemaining(teaList::add);
        return teaList;
    }

    @RequestMapping(method=RequestMethod.PUT, path="/tea")
    public void CreateTea(@RequestBody Tea tea) {
        teaRepository.save(tea);
    }

    @GetMapping(path="/tea/{id}")
    public Tea GetATea(@PathVariable("id") UUID id) {
        Tea tea = teaRepository.findById(id).get();
        return tea;
    }

    @DeleteMapping(path="/tea/{id}")
    public void DeleteTea(@PathVariable("name") UUID id) {
        teaRepository.deleteById(id);
    }

    @PostMapping(path="/tea/{id}")
    public void UpdateTea(@PathVariable("id") UUID id, @RequestBody Tea tea) {
        UUID getId = tea.getId();
        if (!id.equals(getId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Tea Not Found");
        }
        teaRepository.save(tea);
    }
    
}
