package br.gov.sp.itu.fatec.backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.backend.entities.Address;
import br.gov.sp.itu.fatec.backend.expections.EntityFoundException;
import br.gov.sp.itu.fatec.backend.expections.InvalidFieldException;
import br.gov.sp.itu.fatec.backend.repositories.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityFoundException("Address not found"));
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public void parcialUpdate(Long id, Map<String, Object> fields) {
    Address address = findById(id);

    fields.forEach((field, value) -> {
        switch (field) {
        case "number":
            address.setNumber((String) value);
            break;
        case "complement":
            address.setComplement((String) value);
            break;
        case "neighborhood":
            address.setNeighborhood((String) value);
            break;
        case "city":
            address.setCity((String) value);
            break;
        case "state":
            address.setState((String) value);
            break;
        case "country":
            address.setCountry((String) value);
            break;
        case "postalCode":
            address.setPostalCode((String) value);
            break;
        case "street":
            address.setStreet((String) value);
                break;
        default:
            throw new InvalidFieldException("Field not valid: " + field);
        }
    });

    addressRepository.save(address);
    }


    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
