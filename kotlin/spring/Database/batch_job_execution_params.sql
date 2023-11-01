-- Table: public.batch_job_execution_params

-- DROP TABLE IF EXISTS public.batch_job_execution_params;

CREATE TABLE IF NOT EXISTS public.batch_job_execution_params
(
    job_execution_id bigint NOT NULL,
    parameter_name varchar(100) not null,
    parameter_type varchar(100) not null,
    parameter_value varchar(2500),
    identifying character(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT job_exec_params_fk FOREIGN KEY (job_execution_id)
        REFERENCES public.batch_job_execution (job_execution_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.batch_job_execution_params
    OWNER to spring;