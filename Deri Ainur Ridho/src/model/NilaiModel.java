package model;

import classes.BaseModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NilaiModel extends BaseModel<Nilai> {

    public NilaiModel() {
        super("nilai", List.of("id", "mahasiswa_id", "mata_kuliah", "semester", "nilai"));
    }

    @Override
    protected boolean isNewRecord(Nilai nilai) {
        return nilai.getId() == 0; 
    }

    @Override
    protected Nilai mapRow(ResultSet rs) throws SQLException {
        return new Nilai(
            rs.getInt("id"),
            rs.getInt("mahasiswa_id"),
            rs.getString("mata_kuliah"),
            rs.getInt("semester"),
            rs.getDouble("nilai")
        );
    }

    @Override
    protected Object[] getValues(Nilai nilai, boolean includeId) {
        if (includeId) {
            return new Object[]{nilai.getId(), nilai.getMahasiswaId(), nilai.getMataKuliah(), nilai.getSemester(), nilai.getNilai()};
        } else {
            return new Object[]{nilai.getMahasiswaId(), nilai.getMataKuliah(), nilai.getSemester(), nilai.getNilai()};
        }
    }

    public List<Nilai> findByMahasiswaId(int mahasiswaId) {
        return find(); 
    }

    public boolean createNilai(Nilai nilai) {
        return save(nilai); 
    }

    public boolean updateNilai(Nilai nilai) {
        return save(nilai); 
    }

    public boolean deleteNilai(int id) {
        return delete(id); 
    }
}
