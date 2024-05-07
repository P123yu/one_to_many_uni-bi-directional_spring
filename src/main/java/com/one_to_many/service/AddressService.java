package com.one_to_many.service;


import com.one_to_many.model.AddressModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    // getAll
    List<AddressModel> getAll();
}
