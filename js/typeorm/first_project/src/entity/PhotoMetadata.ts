import {
    Entity,
    Column,
    PrimaryGeneratedColumn,
    OneToOne,
    JoinColumn,
    Relation,
} from "typeorm"
import { Photo } from "./Photo"

@Entity()
export class PhotoMetadata {
    @PrimaryGeneratedColumn()
    id: number

    @Column("int")
    height: number

    @Column("int")
    width: number

    @Column()
    orientation: string

    @Column()
    compressed: boolean

    @Column()
    comment: string

    @OneToOne(() => Photo, (photo) => photo.metadata)
    @JoinColumn()
    photo: Relation<Photo>
}