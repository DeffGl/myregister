create table Regs_District (
	districtId LONG not null primary key,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	archived VARCHAR(75) null
);

create table Regs_Farmer (
	farmerId LONG not null primary key,
	organizationName VARCHAR(75) null,
	legalForm VARCHAR(75) null,
	inn VARCHAR(75) null,
	kpp VARCHAR(75) null,
	ogrn VARCHAR(75) null,
	districtId LONG,
	registrationDate DATE null,
	archived VARCHAR(75) null
);

create table Regs_Regs_Farmer_Districts (
	districtId LONG not null,
	farmerId LONG not null,
	primary key (districtId, farmerId)
);