package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.Attendance;
import com.example.ApiClassRoom.repositories.IAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
