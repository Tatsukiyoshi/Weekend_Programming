import 'package:flutter/material.dart';

final bucket = PageStorageBucket();

class PageStorageKeyPage extends StatelessWidget {

  const PageStorageKeyPage({super.key});

  @override
  Widget build(BuildContext context) {
    return PageStorage(
      bucket: bucket,
      child: Scaffold(
        appBar: AppBar(title: const Text('PageStorageKey'), actions: const []),
        body: ListView.builder(
            key: const PageStorageKey<String>("list"),
            itemCount: 20,
            itemBuilder: (context, index) {
              return Container(
                decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(10),
                    border: Border.all(color: Colors.blue)),
                margin: const EdgeInsets.all(5),
                height: 50,
                child: Center(
                  child: Text("sample $index"),
                ),
              );
            }),
      ),
    );
  }
}
