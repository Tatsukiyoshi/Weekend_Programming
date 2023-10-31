-- Table: public.batch_job_instance

-- DROP TABLE IF EXISTS public.batch_job_instance;

CREATE TABLE IF NOT EXISTS public.batch_job_instance
(
    job_instance_id bigint NOT NULL,
    version bigint,
    job_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    job_key character varying(32) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT batch_job_instance_pkey PRIMARY KEY (job_instance_id),
    CONSTRAINT job_inst_un UNIQUE (job_name, job_key)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.batch_job_instance
    OWNER to spring;