package com.microserviciologistic.deleteuser.service;

import com.microserviciologistic.deleteuser.model.User;
import com.microserviciologistic.deleteuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final WebSocketClientService webSocketClientService;

    @Autowired
    public UserService(UserRepository userRepository, WebSocketClientService webSocketClientService) {
        this.userRepository = userRepository;
        this.webSocketClientService = webSocketClientService;

    }

    public void deleteUser(UUID userId) {
        try {
            Optional<User> existingUser = userRepository.findById(userId);
            if (existingUser.isPresent()) {
                userRepository.deleteById(userId);
                System.out.println("Enviando evento WebSocket para creación de usuario...");
                webSocketClientService.sendEvent("DELETE", userId);

            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario con id " + userId + " no encontrado");
            }
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error de conexión a la base de datos: " + e.getMessage(), e);
        }
    }

}
