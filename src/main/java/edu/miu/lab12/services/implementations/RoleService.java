package edu.miu.lab12.services.implementations;

import edu.miu.lab12.models.Role;
import edu.miu.lab12.repositories.RoleRepository;
import edu.miu.lab12.services.IRoleService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll(Sort.by("name"));
    }

}
