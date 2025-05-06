package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.MessagesAPI;
import com.example.ApiClassRoom.models.Attendance;
import com.example.ApiClassRoom.repositories.IAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    IAttendanceRepository repository;

    public Attendance saveAttendance(Attendance attendanceData)throws Exception{
        try {
            return this.repository.save(attendanceData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Attendance modifyAttendance (Integer id, Attendance attendanceData)throws Exception{
        try {
            Optional<Attendance>searchedAttendance=this.repository.findById(id);
            if (searchedAttendance.isPresent()){
                searchedAttendance.get().setDate(attendanceData.getDate());
                searchedAttendance.get().setStatus(attendanceData.getStatus());

                return this.repository.save(searchedAttendance.get());
            }else{
                //No estaba
                throw new Exception("The attendance you are trying to modify does not exist in the database.");

            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR POR ID
    public Attendance searchAttendanceById(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceToFind = this.repository.findById(id);
            if (attendanceToFind.isPresent()) {
                return attendanceToFind.get();
            } else {
                throw new Exception(MessagesAPI.ATTENDANCE_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR TODOS
    public List<Attendance> searchAllAttendances() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // ELIMINAR
    public boolean deleteAttendance(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceToFind = this.repository.findById(id);
            if (attendanceToFind.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(MessagesAPI.ATTENDANCE_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
