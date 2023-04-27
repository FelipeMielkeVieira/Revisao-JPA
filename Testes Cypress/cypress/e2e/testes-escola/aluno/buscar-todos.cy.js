describe("Buscar Todos Alunos", () => {
    it("Buscar Todos Alunos retornando lista", () => {
        cy.request("GET", "http://localhost:8085/aluno").as("BuscarTodos");
        cy.get("@BuscarTodos").then(response => {
            expect(response.status).to.eq(200);
        })
    })
})