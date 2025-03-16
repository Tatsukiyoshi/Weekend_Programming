import {
    Entity,
    Column,
    PrimaryGeneratedColumn,
    OneToOne,
    Relation,
    ManyToOne,
    ManyToMany
} from "typeorm"
import { PhotoMetadata } from "./PhotoMetadata"
import { Author } from "./Author"
import { Album } from "./Album"

@Entity()
export class Photo {
    @PrimaryGeneratedColumn()
    id: number

    @Column({
        length: 100,
    })
    name: string

    @Column("text")
    description: string

    @Column()
    filename: string

    @Column("double")
    views: number

    @Column()
    isPublished: boolean

    @OneToOne(() => PhotoMetadata, (metadata) => metadata.photo,{
        cascade: true
    })
    metadata: Relation<PhotoMetadata>
    @ManyToOne(() => Author, (author) => author.photos, {
        cascade: true
    })
    author: Author

    @ManyToMany(() => Album, (album) => album.photos)
    albums: Album[]
}