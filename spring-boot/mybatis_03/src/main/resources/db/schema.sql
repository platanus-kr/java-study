create table company(
    `id` INT NOT NULL AUTO_INCREMENT,
    `company_name` VARCHAR(255) NULL,
    `company_address` VARCHAR(255) NULL,
    CONSTRAINT PK_company PRIMARY KEY (id)
);

create table employee(
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_id` INT NULL,
  `employee_name` VARCHAR(255) NULL,
  `employee_address` VARCHAR(255) NULL,
  CONSTRAINT PK_employee PRIMARY KEY (id),
  FOREIGN KEY (company_id) REFERENCES company(id)
);