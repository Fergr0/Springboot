package com.example.usarios.demo.service.impl;

import com.example.usarios.demo.model.UsuarioVO;
import com.example.usarios.demo.model.UsuarioDTO;
import com.example.usarios.demo.repository.UsuarioRepository;
import com.example.usarios.demo.service.UsuarioService;
import com.example.usarios.demo.util.UsuarioMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDTO> getUsuarioById(String id) {
        return usuarioRepository.findById(id).map(UsuarioMapper::toDTO);
    }

    @Override
    public List<UsuarioDTO> findByNombreContaining(String nombre) {
        return usuarioRepository.findByNombreContaining(nombre).stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        UsuarioVO usuarioVO = UsuarioMapper.toVO(usuarioDTO);
        UsuarioVO savedUsuario = usuarioRepository.save(usuarioVO);
        return UsuarioMapper.toDTO(savedUsuario);
    }

    @Override
    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsById(usuarioDTO.getId())) {
            UsuarioVO usuarioVO = UsuarioMapper.toVO(usuarioDTO);
            UsuarioVO updatedUsuario = usuarioRepository.save(usuarioVO);
            return UsuarioMapper.toDTO(updatedUsuario);
        }
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUsuario(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteAllUsuarios() {
        usuarioRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @Override
    public UsuarioDTO addTutorialsToUser(String userId, List<String> tutorialIds) {
        Optional<UsuarioVO> usuarioOpt = usuarioRepository.findById(userId);
        if (usuarioOpt.isPresent()) {
            UsuarioVO usuario = usuarioOpt.get();
            usuario.setTutorialIds(tutorialIds);
            usuarioRepository.save(usuario);
            return UsuarioMapper.toDTO(usuario);
        }
        return null;
    }
}
