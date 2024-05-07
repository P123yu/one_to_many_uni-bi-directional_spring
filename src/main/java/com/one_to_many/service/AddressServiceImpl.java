package com.one_to_many.service;

import com.one_to_many.model.AddressModel;
import com.one_to_many.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<AddressModel> getAll() {
        return addressRepository.findAll();
    }
}
