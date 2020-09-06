package com.example.android_game_app_ailatrieuphu.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.android_game_app_ailatrieuphu.object.CauHoi;
import com.example.android_game_app_ailatrieuphu.object.User;

import java.util.ArrayList;

public class MyDatabasehelper extends SQLiteOpenHelper {


    public MyDatabasehelper(@Nullable Context context) {
        super(context, DatabaseOptions.DATA_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DatabaseOptions.CREATE_USERS_TABLE_);
        db.execSQL(DatabaseOptions.CREATE_CAUHOI_TABLE_);
        db.execSQL(DatabaseOptions.CREATE_HISTORY_TABLE);
        cauhoidata(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseOptions.USERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseOptions.CAUHOI_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseOptions.HISTORY_TABLE);
        onCreate(db);
    }

    private void cauhoidata(SQLiteDatabase d) {
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 1,\"" + "Công thức hoá học của Oxi già là gì?" + "\",\"" + "H2O2" + "\",\"" + "O3&H2O&O2" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 1,\"" + "Đâu là tên một loại mũ?" + "\",\"" + "Lưỡi trai" + "\",\"" + "Lưỡi hến&Lưỡi liềm&Lưỡi bò" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 2,\"" + "Điền từ còn thiếu vào chỗ trống sau: 'Ăn quả nhớ kẻ ...'" + "\",\"" + "Trồng cây" + "\",\"" + "Cho trái&hái cho&Chặt cây" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 2,\"" + "Điền từ còn thiếu vào chỗ trống sau: 'Uống nước nhớ ...'" + "\",\"" + "Nguồn" + "\",\"" + "Kẻ trồng cây&Thác&Người đun nước" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 2,\"" + "Đâu là tên một loài hoa?" + "\",\"" + "Loa kèn" + "\",\"" + "Loa phường&Loa báo&Loa đài" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 3,\"" + "Đâu là thủ đô của Việt Nam?" + "\",\"" + "Hà Nội" + "\",\"" + "Hồ Chí Minh&Đà Nẵng&Nha Trang" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 3,\"" + "Tên một cầu thủ bóng đá?" + "\",\"" + "Quang Hải" + "\",\"" + "Quang Thắng&Quang Tèo&Quang Trung" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 4,\"" + "Người ta thường nói: 'Bới lông tìm ...'" + "\",\"" + "Vết" + "\",\"" + "Rận&Chấy&Ve" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 4,\"" + "Quy Nhơn là thành phố thuộc tỉnh nào?" + "\",\"" + "Bình Định" + "\",\"" + "Kiên Giang&Bạc Liêu&An Giang" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 5,\"" + "Đâu là một câu thành ngữ?" + "\",\"" + "Ba mặt một lời" + "\",\"" + "Một mặt hai lời&Ba mặt sáu lời&Năm mặt tám lời" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 5,\"" + "Số nào sau đây chia hết cho 3?" + "\",\"" + "27" + "\",\"" + "7&17&37" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 6,\"" + "Vợ của nghệ sỹ Xuân Bắc tên là gì?" + "\",\"" + "Hồng Nhung" + "\",\"" + "Cẩm Chướng&Tuylip&Anh Đào" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 6,\"" + "Nam diễn viên nào nổi tiếng với vai diễn Mr Bean trong bộ phim cùng tên" + "\",\"" + "Rowan Atkinson" + "\",\"" + "Jude Law&Eddie Murphy&Tom Cruise" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 7,\"" + "Trong các bài thơ dưới đây, bài nào không phải của Tú Xương?" + "\",\"" + "Bài ca ngất ngưởng" + "\",\"" + "Sông Lấp&Vịnh hoa thi Hương&Áo bông che bạn" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 7,\"" + "Người đẹp nước nào đã giành vương miện Hoa hậu Hoàn vũ thế giới năm 2018?" + "\",\"" + "Philippines" + "\",\"" + "Việt Nam&Nam Phi&Venezuela" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 8,\"" + "Thuật Yoga bắt nguồn từ quốc gia nào?" + "\",\"" + "Ấn Độ" + "\",\"" + "Nhật Bản&Hàn Quốc&Trung Quốc" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 8,\"" + "Địa danh nào được nhắc đến trong bản vọng cổ: 'Tình anh bán chiếu' ?" + "\",\"" + "Cà Mau" + "\",\"" + "Bạc Liêu&Trà Vinh&Hậu Giang" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 9,\"" + "Tỉnh nào dưới đây có bài dân ca 'Đi cấy'?" + "\",\"" + "Thanh Hóa" + "\",\"" + "Thái Bình&Nghệ An&Quảng Bình" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 9,\"" + "Bàn tay của nhân vật hoạt hình chuột Mickey có bao nhiêu ngón?" + "\",\"" + "4" + "\",\"" + "2&3&5" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 10,\"" + "Phố Chả Cá (Hà Nội) trước đây có tên là gì?" + "\",\"" + "Hàng Sơn" + "\",\"" + "Hàng Tiện&Sinh Từ&Lã Vọng" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 10,\"" + "Nước nào có bảo tàng gián điệp quốc tế?" + "\",\"" + "Mỹ" + "\",\"" + "Anh&Pháp&Nga" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 11,\"" + "Tên của Nữ hoàng nào dưới đây được đặt cho một phong cách kiến trúc?" + "\",\"" + "Queen Anne" + "\",\"" + "Cleopatra&Catherine Đại Đế&Margrethe" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 11,\"" + "Số 3 được viết thế nào trong hệ nhị phân?" + "\",\"" + "0011" + "\",\"" + "0001&0010&0111" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 12,\"" + "Phương pháp in bằng chữ rời do người Đức sáng chế năm 1440, gọi là gì" + "\",\"" + "In typô" + "\",\"" + "In litô kẽm&In ống đồng&In hòa mầu" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 12,\"" + "Bức tranh 'Nguyện ước' là của họa sĩ nổi tiếng nào?" + "\",\"" + "Nguyễn Tư Nghiêm" + "\",\"" + "Dương Bích Liên&Trần Văn Cẩn&Bùi Xuân Phái" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 13,\"" + "Nhà văn châu Phi đầu tiên đoạt giải Nobel Văn học đến từ đất nước nào?" + "\",\"" + "Nigeria" + "\",\"" + "Nam Phi&Liberia&Ghana" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 13,\"" + "'Chị Hòa', 'Một Đảng viên', 'Ni cô Đàm Vân' đều là vở kịch của tác giả nào?" + "\",\"" + "Học Phi" + "\",\"" + "Thế Lữ&Nguyễn Huy Tưởng&Nguyễn Đình Nghi" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 14,\"" + "Trong kho tàng văn học cổ, phần nào không có trong bố cục một bài văn tế" + "\",\"" + "Luận" + "\",\"" + "Lung khởi&Thích thực&Kết" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 14,\"" + "'Hòn đảo thần Vệ Nữ' là biệt danh của quốc đảo nào? " + "\",\"" + "Cyprus" + "\",\"" + "Malta&Cuba&Singapore" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 15,\"" + "Việt Nam gia nhập tổ chức ASEAN vào năm nào?" + "\",\"" + "1995" + "\",\"" + "1992&1997&1998" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 15,\"" + "Ai là tác giả của bài quốc ca Ấn Độ và Bangladesh?" + "\",\"" + "Tagore" + "\",\"" + "Dom Moraes&Ramakanta Rath&Prend Cham" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id, capdo, noidung, dapan, dapansai) VALUES(null, 15,\"" + "Nhóm máu nào chỉ có thể truyền cho chính nó?" + "\",\"" + "AB" + "\",\"" + "A&B&O" + "\");");
    }

    public User queryUser(String email, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        User user = null;

        Cursor cursor = db.query(DatabaseOptions.USERS_TABLE, new String[]{DatabaseOptions.ID_USER,
                        DatabaseOptions.EMAIL, DatabaseOptions.PASSWORD, DatabaseOptions.TOTAL_POINT}, DatabaseOptions.EMAIL + "=? and " + DatabaseOptions.PASSWORD + "=?",
                new String[]{email, password}, null, null, null, "1");
        if (cursor != null)
            cursor.moveToFirst();
        if (cursor != null && cursor.getCount() > 0) {
            user = new User(cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        // return user
        return user;
    }

    public boolean addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseOptions.EMAIL, user.getEmail());
        values.put(DatabaseOptions.PASSWORD, user.getPassword());
        values.put(DatabaseOptions.TOTAL_POINT, "0");

        // Inserting Row
        long res = db.insert(DatabaseOptions.USERS_TABLE, null, values);
        db.close(); // Closing database connection
        if (res == -1) return false;
        else return true;
    }

    public boolean checkUser(String user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email =?", new String[]{user});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    public void addPoint(String email, String point) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE users SET totalpoint =? WHERE email =?";
        db.execSQL(sql, new String[]{point, String.valueOf(email)});
        db.close();
    }

    public boolean insertHistory(String email, String changepoint, String note) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values;
        values = new ContentValues();
        values.put(DatabaseOptions.EMAIL_HISTORY, email);
        values.put(DatabaseOptions.CHANGE_POINT, changepoint);
        values.put(DatabaseOptions.NOTE, note);
        long res = db.insert("history", null, values);

        db.close();
        if (res == -1) return false;
        else return true;
//        db.execSQL("INSERT INTO history (email, changepoint, note) VALUES("+"123,"+"+2000,"+"win);");
//        db.close();
//        return true;
//        db.execSQL("INSERT INTO history (email, changepoint, note) VALUES(?,?,?);",new String[]{email,changepoint,note});
//        db.close();
//        return true;
    }

    //    public ArrayList<String> getHistory(String email) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        ArrayList<String> arrayListH = new ArrayList<>();
////        db.execSQL(DatabaseOptions.CREATE_HISTORY_TABLE);
//        Cursor cursor = db.query(DatabaseOptions.HISTORY_TABLE, new String[]{
//                        DatabaseOptions.EMAIL_HISTORY, DatabaseOptions.CHANGE_POINT, DatabaseOptions.NOTE}, DatabaseOptions.EMAIL_HISTORY + "=?",
//                new String[]{email}, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//        if (cursor != null && cursor.getCount() > 0) {
//            while (cursor.moveToNext()) {
//                String changepoint = cursor.getString(cursor.getColumnIndex("changepoint"));
//                String note = cursor.getString(cursor.getColumnIndex("note"));
//                String result=changepoint+"|"+note;
//                arrayListH.add(result);
//            }
//        }
//        return arrayListH;
//    }
    public Cursor getHistory(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from history where email =?",new String[]{email});
        return cursor;
    }

}
