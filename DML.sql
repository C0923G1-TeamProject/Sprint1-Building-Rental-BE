-- insert into Employee --  

insert into employee(code,name,address,date,email,gender,department,phone_number,profile_picture,salary_level,start_date)
values("NV-0001","Trần Kim Tiểu Vi","295 Nguyễn Tất Thành,Quận Thanh Khê, Thành phố Đà Nẵng","hinhhockhonggian3@gmail.com","2009-09-09",1,"Nhân viên văn phòng",0921313144,"https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg","bậc 4","2023/09/01"),
("NV-0002","Trần Thị Hồng Thắm","295 Nguyễn Tất Thành,Quận Thanh Khê, Thành phố Đà Nẵng","thamtth123@gmail.com","2004-03-22",1,"Nhân viên văn phòng",0912312313,"https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg","bậc 4","2023/09/01"),
("NV-0003","Trần Linh Giang","280 Trần Hưng Đạo,Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng","giangladongsong123@gmail.com","2006-02-29",1,"Nhân viên phục vụ",0912312312,"https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg","bậc 4","2023/09/01");

-- insert into Role + Account --  
insert into role(name)
values("admin"),("employee");

insert into account(username,password,id_employee,id_role)
values("vitkt","123456",1,1),
("thamtth","123456",2,2),
("gianglds",123456,3,2);

-- insert into MB --  

insert into premises_status(name)
values("Chưa bàn giao"),("Đã bàn giao"),("Đang sửa chữa"),("Vào ở");

insert into premises(code,area,cost,description,floor,price,premises_status_id,id_type_premises)
values("MB-001",100,500000,"",1,12000000,1,1),
("MB-002",200,400000,"",2,10000000,3,2),
("MB-003",1220,500000,"",3,130000000,2,3);

insert into type_premises(name)
values("Mặt đứng"),("Mặt hậu"),("Mặt cắt");

-- insert into customer -- 

insert into customer(name,date,address,card,company,email,img,phone_number,url_website)
values("Nguyễn Đình Hòa","1992-09-03","Thành phố Hà Nội",343434343112,"Hoa thiên phú","HoaND@gmail.com","https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg",095456789,"hoaminnzi.com"),
("Nguyễn Đình Hòa","1992-09-03","Thành phố Hà Nội","343432432","Nguyễn Ngọc Đông","dongnguyen@gmail.com","https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg",09542131232,"hoaminnzi.com"),
("Nguyễn Đình Hòa","1992-09-03","Thành phố Hà Nội",343432432,"Hoàng Lê Quang","quangHoang@gmail.com","https://cdn.sforum.vn/sforum/wp-content/uploads/2023/10/avatar-trang-4.jpg",0954872378,"hoaminnzi.com");

-- insert into Contract --  

insert into contract_status(name)
values("Còn hiệu lực"),("Hết hiệu lực");

insert into contract(code,content,deposit,start_date,end_date,payment_term,id_account,id_contract_status,id_customer,id_premises)
values("HD-0001","Bên A đồng ý các thỏa thuận",25000000,"2023-01-01","2024-01-01",25000000,1,1,1,1),
("HD-0002","Bên A đồng ý các thỏa thuận",227000000,"2023-02-01","2024-02-01",27000000,2,1,2,2),
("HD-0003","Bên A đồng ý các thỏa thuận",30000000,"2023-03-01","2024-03-01",300000000,3,2,3,3);

-- insert into Customer --

insert into customer(name,card,email,date,phone_number,address,url_website,company,img)
value("Nguyễn Văn Cường", "76598753434", "cuongnv@gmail.com", "2021-03-22", "0988575981", "Cầu Giấy,Hà Nội", "hoahuongduong.com", "Hoa Hướng Dương", "https://studiochupanhdep.com/Upload/Images/Album/anh-the-2024.jpg");


  


