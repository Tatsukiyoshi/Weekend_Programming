-- Table: public.batch_job_execution_context

-- DROP TABLE IF EXISTS public.batch_job_execution_context;

CREATE TABLE IF NOT EXISTS public.batch_job_execution_context
(
    job_execution_id bigint NOT NULL,
    short_context character varying(2500) COLLATE pg_catalog."default" NOT NULL,
    serialized_context text COLLATE pg_catalog."default",
    CONSTRAINT batch_job_execution_context_pkey PRIMARY KEY (job_execution_id),
    CONSTRAINT job_exec_ctx_fk FOREIGN KEY (job_execution_id)
        REFERENCES public.batch_job_execution (job_execution_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.batch_job_execution_context
    OWNER to spring;