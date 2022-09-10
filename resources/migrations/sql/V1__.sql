CREATE TABLE "customer" (
    "id" uuid NOT NULL,
    "first_name" varchar(50),
    "last_name" varchar(50),
    "email" varchar(100) NOT NULL UNIQUE,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);