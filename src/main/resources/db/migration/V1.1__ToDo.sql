CREATE SEQUENCE autoid;

CREATE TABLE public.users
(
    id bigint NOT NULL DEFAULT nextval('autoid'::regclass),
    username character varying NOT NULL,
    password character varying NOT NULL,
    PRIMARY KEY (id)
);


ALTER TABLE IF EXISTS public.users
    OWNER to postgres;
    
ALTER SEQUENCE autoid OWNED BY users.id;

CREATE SEQUENCE userid;

CREATE TABLE public.todos_list
(
    id bigint NOT NULL DEFAULT nextval('userid'::regclass),
    user_id bigint NOT NULL,
    title character varying NOT NULL,
    description character varying NOT NULL,
    PRIMARY KEY (id)
);


ALTER TABLE IF EXISTS public.todos_list
    OWNER to postgres;
ALTER SEQUENCE userid OWNED BY todos_list.id;
