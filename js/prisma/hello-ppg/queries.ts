// 1
import { PrismaClient } from '@prisma/client'
import { withAccelerate } from '@prisma/extension-accelerate'

// 2
const prisma = new PrismaClient()
    .$extends(withAccelerate())

// 3
async function main() {
    // ... you will write your Prisma Client queries here
    await prisma.user.create({
        data: {
        name: 'Alice',
        email: 'alice@prisma.io',
        posts: {
            create: { title: 'Hello World' },
        },
        profile: {
            create: { bio: 'I like turtles' },
        },
        },
    })

    const allUsers = await prisma.user.findMany({
        include: {
        posts: true,
        profile: true,
        },
    })
    console.dir(allUsers, { depth: null })
}

// 4
main()
    .then(async () => {
        await prisma.$disconnect()
    })
    .catch(async (e) => {
        console.error(e)
        // 5
        await prisma.$disconnect()
        process.exit(1)
    })
