describe("Buscar Endereço com ID 1", () => {
    it("Buscar endereço com ID 1 retorna endereço certo", () => {
        cy.request("GET", "http://localhost:8085/endereco/1").as("BuscarEndereco");
        cy.get("@BuscarEndereco").then(response => {
            expect(response.body).to.be.a("object")
        })
    })
})