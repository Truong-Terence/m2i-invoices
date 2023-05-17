package com.tp.biller.controller;

import com.tp.biller.entity.Bill;
import com.tp.biller.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("bill", new Bill());
        return "bill-create";
    }

    @PostMapping("/create")
    public String createBill(@ModelAttribute("bill") Bill bill) {
        billRepository.save(bill);
        return "redirect:/dashboard";
    }
}

