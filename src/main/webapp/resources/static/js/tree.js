var tree= [];


function getTree() {
  // Some logic to retrieve, or generate tree structure
  tree = [{
    text: "Connections",
    nodes:[
      {
      text:"banco1",
        nodes:[
          {
          text:"tabela 1",
          },
          {
            text:"tabela 2"
          }
        ]
      },
      {
      text:"banco1",
        nodes:[
          {
          text:"tabela 1"
          },
          {
            text:"tabela 2"
          }
        ]
      },
    ]
    }];
    console.log(tree);
    return tree;
}


$('#tree').treeview({data: getTree(),levels: 2,  showBorder: true });



//databaseObject = {databaseName: <name_database>, tables:[<name_table_1>,<name_table_2>,<name_table_3>]}
function addDatabase(databaseObject){
	var tables =[];
	databaseObject.tables.forEach(function(table){
		tables.push(addTable(table));
	});
	

	var database = {text: "databaseName",nodes:tables}

	tree[0].nodes.push(database);

	$('#tree').treeview({data: tree,levels: 2,  showBorder: false });
}

function addTable(tableName){
	var table = {text: tableName};
	return table
}

function createTree(treeArray){
  $('#tree').treeview({data: treeArray,levels: 2,  showBorder: false });
}

// addDatabase({"databaseName":"testeBanco", "tables":["tabelaTeste1","tabelaTeste2"]})