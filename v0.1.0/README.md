# IOF Data Standard, version 0.1.0

> ⚠️ **WARNING:** this page refers to an outdated version of the data standard. [Find here](https://github.com/international-orienteering-federation/datastandard-v3) the latest version

> ⚠️**Renumbered versions:** As work in progress the standard was numbered 1.0 to 1.5. But to mark these as unfinished an extra 0 has been added. So now they are numbered 0.1.0 to 0.1.5. The official standard (proposal version 1.6) is numbered 1.0.


This proposal for the IOF Standard Information Exchange using Extensible Markup Language (XML) assumes that users of these standards will want some flexibility depending on their situation.  In order to achieve this I have created DataTypeDefinitions (DTD) for single Entities. A standard set or collection of data such as Results is then created using a complex DTD which simply includes the necessary DTDs for each entity it needs to support.

This proposal extends the work done by the IOF Standards Committee and specifically the proposal to use [XML provided](https://github.com/international-orienteering-federation/datastandard-v1/wiki/Initial-thoughts) by Mr. Ian Watson of GBR.