const {Sequelize, DataTypes} = require('sequelize');
const sequelize = new Sequelize('postgres://sequelize:password@localhost:5432/sequelize') // Example for postgres

const User = sequelize.define('User', {
  firstName : {
    type: DataTypes.STRING,
    allowNull: false
  },
  lastName : {
    type: DataTypes.STRING
  },
  age : {
    type: DataTypes.INTEGER
  }
}, {
});

(async()=>{
  await User.sync({ force: true});

  // createでデータを挿入する例
  const user1 = await User.create({
    firstName : 'alice',
    lastName : 'husigi',
    age : 23
  });
  // build+saveでデータを挿入する例
  const user2 = User.build({
    firstName : 'Joe',
    lastName : 'Yabuki',
    age : 18
  });
  await user2.save();

  // 単純なSELECTクエリの例
  let users = await User.findAll();
  users.map(user=> console.log(user.firstName, user.lastName, user.age));

  // 更新の例
  const userJoe = await User.findOne({where: {firstName: 'Joe'} });
  userJoe.age = 20;
  await userJoe.save();

  // 更新後の確認
  users = await User.findAll();
  users.map(user=> console.log(user.firstName, user.lastName, user.age));

  // 削除の例
  await userJoe.destroy();
  users = await User.findAll();
  users.map(user=> console.log(user.firstName, user.lastName, user.age));

})();
